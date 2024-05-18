import com.example.myfirstapp.data.conection.ApiConnection
import com.example.myfirstapp.data.network.endpoints.MarvelEndpoint
import com.example.myfirstapp.data.network.entities.marvel.characters.database.MarvelCharsBD
import com.example.myfirstapp.data.network.entities.marvel.characters.getMarvelChars
import com.example.myfirstapp.ui.utilities.DispositivosMoviles


class MarvelLogic {

    suspend fun getMarvelChars(name: String, limit: Int): ArrayList<MarvelChars> {

        var itemList = arrayListOf<MarvelChars>()


        val response =
            ApiConnection.getService(ApiConnection.typeApi.Marvel, MarvelEndpoint::class.java)
                .getCharacterStartWith(name, limit)

        if (response.isSuccessful) {
            response.body()!!.data.results.forEach {

                val m = it.getMarvelChars()
                itemList.add(m)
            }
        }

        return itemList
    }

    suspend fun getAllMarvelChars(offset: Int, limit: Int): ArrayList<MarvelChars> {

        var itemList = arrayListOf<MarvelChars>()


        val response =
            ApiConnection.getService(ApiConnection.typeApi.Marvel, MarvelEndpoint::class.java)
                .getAllMarvelChars(offset, limit)

        if (response.isSuccessful) {
            response.body()!!.data.results.forEach {
                val m = it.getMarvelChars()
                itemList.add(m)
            }
        }

        return itemList
    }

    suspend fun getAllMarvelChardDB(): List<MarvelChars> {
        val items: ArrayList<MarvelChars> = arrayListOf()
        val items_aux = DispositivosMoviles.getDbInstance().marvelDao().getAllCharacters()
        items_aux.forEach {
            items.add(
                MarvelChars(
                    it.id, it.name, it.comic, it.image
                )
            )
        }
        return items
    }

    suspend fun getInitChars(limit: Int, offset: Int): MutableList<MarvelChars> {

        var items = mutableListOf<MarvelChars>()
        try {

            items = MarvelLogic().getAllMarvelChardDB().toMutableList()


            if (items.isEmpty()) {
                items = MarvelLogic().getAllMarvelChars(offset, limit)
                MarvelLogic().insertMarvelCharstoDB(items)
            }

        } catch (ex: Exception) {
            throw RuntimeException(ex.message)

        }finally {
            return items
        }





    }

    suspend fun insertMarvelCharstoDB(items: List<MarvelChars>){

        var itemsDB = arrayListOf<MarvelCharsBD>()


        items.forEach {
            itemsDB.add(it.getMarvelCharsDB())
        }

        DispositivosMoviles.getDbInstance().marvelDao().insertMarvelChar(itemsDB)

    }
}
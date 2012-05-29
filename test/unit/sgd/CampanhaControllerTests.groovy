package sgd



import org.junit.*
import grails.test.mixin.*

@TestFor(CampanhaController)
@Mock(Campanha)
class CampanhaControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/campanha/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.campanhaInstanceList.size() == 0
        assert model.campanhaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.campanhaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.campanhaInstance != null
        assert view == '/campanha/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/campanha/show/1'
        assert controller.flash.message != null
        assert Campanha.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/campanha/list'


        populateValidParams(params)
        def campanha = new Campanha(params)

        assert campanha.save() != null

        params.id = campanha.id

        def model = controller.show()

        assert model.campanhaInstance == campanha
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/campanha/list'


        populateValidParams(params)
        def campanha = new Campanha(params)

        assert campanha.save() != null

        params.id = campanha.id

        def model = controller.edit()

        assert model.campanhaInstance == campanha
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/campanha/list'

        response.reset()


        populateValidParams(params)
        def campanha = new Campanha(params)

        assert campanha.save() != null

        // test invalid parameters in update
        params.id = campanha.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/campanha/edit"
        assert model.campanhaInstance != null

        campanha.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/campanha/show/$campanha.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        campanha.clearErrors()

        populateValidParams(params)
        params.id = campanha.id
        params.version = -1
        controller.update()

        assert view == "/campanha/edit"
        assert model.campanhaInstance != null
        assert model.campanhaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/campanha/list'

        response.reset()

        populateValidParams(params)
        def campanha = new Campanha(params)

        assert campanha.save() != null
        assert Campanha.count() == 1

        params.id = campanha.id

        controller.delete()

        assert Campanha.count() == 0
        assert Campanha.get(campanha.id) == null
        assert response.redirectedUrl == '/campanha/list'
    }
}

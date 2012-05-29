package sgd



import org.junit.*
import grails.test.mixin.*

@TestFor(SemeadorController)
@Mock(Semeador)
class SemeadorControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/semeador/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.semeadorInstanceList.size() == 0
        assert model.semeadorInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.semeadorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.semeadorInstance != null
        assert view == '/semeador/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/semeador/show/1'
        assert controller.flash.message != null
        assert Semeador.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/semeador/list'


        populateValidParams(params)
        def semeador = new Semeador(params)

        assert semeador.save() != null

        params.id = semeador.id

        def model = controller.show()

        assert model.semeadorInstance == semeador
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/semeador/list'


        populateValidParams(params)
        def semeador = new Semeador(params)

        assert semeador.save() != null

        params.id = semeador.id

        def model = controller.edit()

        assert model.semeadorInstance == semeador
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/semeador/list'

        response.reset()


        populateValidParams(params)
        def semeador = new Semeador(params)

        assert semeador.save() != null

        // test invalid parameters in update
        params.id = semeador.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/semeador/edit"
        assert model.semeadorInstance != null

        semeador.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/semeador/show/$semeador.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        semeador.clearErrors()

        populateValidParams(params)
        params.id = semeador.id
        params.version = -1
        controller.update()

        assert view == "/semeador/edit"
        assert model.semeadorInstance != null
        assert model.semeadorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/semeador/list'

        response.reset()

        populateValidParams(params)
        def semeador = new Semeador(params)

        assert semeador.save() != null
        assert Semeador.count() == 1

        params.id = semeador.id

        controller.delete()

        assert Semeador.count() == 0
        assert Semeador.get(semeador.id) == null
        assert response.redirectedUrl == '/semeador/list'
    }
}

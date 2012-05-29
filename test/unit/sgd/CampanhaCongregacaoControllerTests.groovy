package sgd



import org.junit.*
import grails.test.mixin.*

@TestFor(CampanhaCongregacaoController)
@Mock(CampanhaCongregacao)
class CampanhaCongregacaoControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/campanhaCongregacao/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.campanhaCongregacaoInstanceList.size() == 0
        assert model.campanhaCongregacaoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.campanhaCongregacaoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.campanhaCongregacaoInstance != null
        assert view == '/campanhaCongregacao/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/campanhaCongregacao/show/1'
        assert controller.flash.message != null
        assert CampanhaCongregacao.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/campanhaCongregacao/list'


        populateValidParams(params)
        def campanhaCongregacao = new CampanhaCongregacao(params)

        assert campanhaCongregacao.save() != null

        params.id = campanhaCongregacao.id

        def model = controller.show()

        assert model.campanhaCongregacaoInstance == campanhaCongregacao
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/campanhaCongregacao/list'


        populateValidParams(params)
        def campanhaCongregacao = new CampanhaCongregacao(params)

        assert campanhaCongregacao.save() != null

        params.id = campanhaCongregacao.id

        def model = controller.edit()

        assert model.campanhaCongregacaoInstance == campanhaCongregacao
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/campanhaCongregacao/list'

        response.reset()


        populateValidParams(params)
        def campanhaCongregacao = new CampanhaCongregacao(params)

        assert campanhaCongregacao.save() != null

        // test invalid parameters in update
        params.id = campanhaCongregacao.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/campanhaCongregacao/edit"
        assert model.campanhaCongregacaoInstance != null

        campanhaCongregacao.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/campanhaCongregacao/show/$campanhaCongregacao.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        campanhaCongregacao.clearErrors()

        populateValidParams(params)
        params.id = campanhaCongregacao.id
        params.version = -1
        controller.update()

        assert view == "/campanhaCongregacao/edit"
        assert model.campanhaCongregacaoInstance != null
        assert model.campanhaCongregacaoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/campanhaCongregacao/list'

        response.reset()

        populateValidParams(params)
        def campanhaCongregacao = new CampanhaCongregacao(params)

        assert campanhaCongregacao.save() != null
        assert CampanhaCongregacao.count() == 1

        params.id = campanhaCongregacao.id

        controller.delete()

        assert CampanhaCongregacao.count() == 0
        assert CampanhaCongregacao.get(campanhaCongregacao.id) == null
        assert response.redirectedUrl == '/campanhaCongregacao/list'
    }
}

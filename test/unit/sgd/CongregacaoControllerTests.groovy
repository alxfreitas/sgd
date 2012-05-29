package sgd



import org.junit.*
import grails.test.mixin.*

@TestFor(CongregacaoController)
@Mock(Congregacao)
class CongregacaoControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/congregacao/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.congregacaoInstanceList.size() == 0
        assert model.congregacaoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.congregacaoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.congregacaoInstance != null
        assert view == '/congregacao/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/congregacao/show/1'
        assert controller.flash.message != null
        assert Congregacao.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/congregacao/list'


        populateValidParams(params)
        def congregacao = new Congregacao(params)

        assert congregacao.save() != null

        params.id = congregacao.id

        def model = controller.show()

        assert model.congregacaoInstance == congregacao
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/congregacao/list'


        populateValidParams(params)
        def congregacao = new Congregacao(params)

        assert congregacao.save() != null

        params.id = congregacao.id

        def model = controller.edit()

        assert model.congregacaoInstance == congregacao
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/congregacao/list'

        response.reset()


        populateValidParams(params)
        def congregacao = new Congregacao(params)

        assert congregacao.save() != null

        // test invalid parameters in update
        params.id = congregacao.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/congregacao/edit"
        assert model.congregacaoInstance != null

        congregacao.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/congregacao/show/$congregacao.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        congregacao.clearErrors()

        populateValidParams(params)
        params.id = congregacao.id
        params.version = -1
        controller.update()

        assert view == "/congregacao/edit"
        assert model.congregacaoInstance != null
        assert model.congregacaoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/congregacao/list'

        response.reset()

        populateValidParams(params)
        def congregacao = new Congregacao(params)

        assert congregacao.save() != null
        assert Congregacao.count() == 1

        params.id = congregacao.id

        controller.delete()

        assert Congregacao.count() == 0
        assert Congregacao.get(congregacao.id) == null
        assert response.redirectedUrl == '/congregacao/list'
    }
}

package sgd



import org.junit.*
import grails.test.mixin.*

@TestFor(DoacaoController)
@Mock(Doacao)
class DoacaoControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/doacao/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.doacaoInstanceList.size() == 0
        assert model.doacaoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.doacaoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.doacaoInstance != null
        assert view == '/doacao/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/doacao/show/1'
        assert controller.flash.message != null
        assert Doacao.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/doacao/list'


        populateValidParams(params)
        def doacao = new Doacao(params)

        assert doacao.save() != null

        params.id = doacao.id

        def model = controller.show()

        assert model.doacaoInstance == doacao
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/doacao/list'


        populateValidParams(params)
        def doacao = new Doacao(params)

        assert doacao.save() != null

        params.id = doacao.id

        def model = controller.edit()

        assert model.doacaoInstance == doacao
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/doacao/list'

        response.reset()


        populateValidParams(params)
        def doacao = new Doacao(params)

        assert doacao.save() != null

        // test invalid parameters in update
        params.id = doacao.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/doacao/edit"
        assert model.doacaoInstance != null

        doacao.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/doacao/show/$doacao.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        doacao.clearErrors()

        populateValidParams(params)
        params.id = doacao.id
        params.version = -1
        controller.update()

        assert view == "/doacao/edit"
        assert model.doacaoInstance != null
        assert model.doacaoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/doacao/list'

        response.reset()

        populateValidParams(params)
        def doacao = new Doacao(params)

        assert doacao.save() != null
        assert Doacao.count() == 1

        params.id = doacao.id

        controller.delete()

        assert Doacao.count() == 0
        assert Doacao.get(doacao.id) == null
        assert response.redirectedUrl == '/doacao/list'
    }
}

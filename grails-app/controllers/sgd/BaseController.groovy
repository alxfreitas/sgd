package sgd

abstract class BaseController {

    def beforeInterceptor = [action:this.&auth,except:['login', 'authenticate']]

    private static final String HEADER_PRAGMA = "Pragma";
    private static final String HEADER_EXPIRES = "Expires";
    private static final String HEADER_CACHE_CONTROL = "Cache-Control";

    protected preventCache (response) {
        response.setHeader(HEADER_PRAGMA, "no-cache");
        response.setDateHeader(HEADER_EXPIRES, 1L);
        response.setHeader(HEADER_CACHE_CONTROL, "no-cache");
        response.addHeader(HEADER_CACHE_CONTROL, "no-store");
    }

    def auth() {
        preventCache(response)
        if(!session.usuario) {
            redirect(controller:'usuario',action:'login')
            return false
        }
        else {
            return true
        }
    }

    def home(){}
}



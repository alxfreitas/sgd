import sun.misc.BASE64Encoder
import java.security.MessageDigest
import org.apache.commons.codec.binary.Base64
import sun.misc.BASE64Decoder
/**
 * Created by IntelliJ IDEA.
 * User: Nois
 * Date: 19/05/12
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
class PasswordCodec {
    /*
    static encode = { str ->
		MessageDigest md = MessageDigest.getInstance("SHA")
		md.update(str.getBytes('UTF-8'))

		return (new BASE64Encoder()).encode(md.digest())
	}

    static decode = { str ->
        new BASE64Decoder().

    }
    */

    static encode = { str ->
        return new String(Base64.encodeBase64(str.getBytes()))
    }

    static decode = { str ->
        if(str){
            return new String(Base64.decodeBase64(str))
        }

    }
}

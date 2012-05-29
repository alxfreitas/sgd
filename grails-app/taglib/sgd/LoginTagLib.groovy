package sgd

class LoginTagLib {
       def loginControl = {
    if(session.usuario){
      out << "Bem vindo ${session.usuario.login} "
      out << """[${link(action:"logout", controller:"usuario"){"Logout"}}]"""
    }
  }
}

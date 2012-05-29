<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>SGD - Sistema de Gestão de Doações</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css">


</head>
<body>
<div class="container">
    <section id="content">
        <g:form action="authenticate" method="post" >
            <h1>Autenticação</h1>

            <div>
                <input type="text" placeholder="Usuário" required="" id="login" name="login" />
            </div>
            <div>
                <input type="password" placeholder="Senha" required="" id="senha" name="senha" />
            </div>
            <div>
                <input type="submit" value="Entrar" />


            </div>
        </g:form><!-- form -->
    </section><!-- content -->
</div><!-- container -->
</body>
</html>
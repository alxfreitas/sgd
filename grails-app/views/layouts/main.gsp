<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
    <%--<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">  --%>

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery.dataTables.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery.treeview.css')}" type="text/css">

    <%--<link rel="stylesheet" href="${resource(dir: 'css/extjs/style/css', file: 'ext-all.css')}" type="text/css">
    <script type="text/javascript" src="${resource(dir: 'js/extjs', file: 'ext-all.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js/extjs', file: 'bootstrap.js')}"></script>--%>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.dataTables.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.price_format.1.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.maskedinput-1.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.treeview.js')}"></script>




    <g:layoutHead/>
    <r:layoutResources />
</head>

<body>
<div id="grailsLogo" role="banner"><img src="${resource(dir: 'images', file: 'logoSemente.png')}" alt="SGD"/>
    <div id="login" style=" float: right;   padding-top: 29px;">
        <g:loginControl  />
    </div>

</div>
<g:layoutBody/>
<div class="footer" role="contentinfo">
    <div align="center">Copyright &copy; 2012 - IGREJA EVANGÉLICA ASSEMBLÉIA DE DEUS - BELA VISTA</div>

</div>



<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<g:javascript library="application"/>
<r:layoutResources />
</body>
</html>
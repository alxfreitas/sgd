<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }

    .clear {clear:both}
        /* remove the list style */
    #menuNav {
        margin:0;
        padding:0;
        list-style:none;
    }

        /* make the LI display inline */
        /* it's position relative so that position absolute */
        /* can be used in submenu */
    #menuNav li {
        float:left;
        display:block;
        width:100px;
        background:#ccc;
        position:relative;
        z-index:500;
        margin:0 1px;
    }

        /* this is the parent menu */
    #menuNav li a {
        display:block;
        padding:8px 5px 0 5px;
        font-weight:700;
        height:23px;
        text-decoration:none;
        color:#fff;
        text-align:center;
        color:#333;
    }

    #menuNav li a:hover {
        color:#fff;
        width:auto;
    }

        /* you can make a different style for default selected value */
    #menuNav a.selected {
        color:#f00;
    }

        /* submenu, it's hidden by default */
    #menuNav ul {
        position:absolute;
        left:0;
        display:none;
        margin:0 0 0 -1px;
        padding:0;
        list-style:none;
    }

    #menuNav ul li {
        /*width:100px;*/
        float:left;
        border-top:1px solid #fff;
    }

        /* display block will make the link fill the whole area of LI */
    #menuNav ul a {
        display:block;
        /*height:15px;*/
        /*padding: 8px 5px;   */
        color:#666;
    }

    #menuNav ul a:hover {
        text-decoration:underline;
    }

        /* fix ie6 small issue */
        /* we should always avoid using hack like this */
        /* should put it into separate file : ) */
    *html #menuNav ul {
        margin:0 0 0 -2px;
    }
    </style>
    <script>
        $(document).ready(function () {

            $('#menuNav li').hover(
                    function () {
                        //show its submenu
                        $('ul', this).slideDown(100);

                    },
                    function () {
                        //hide its submenu
                        $('ul', this).slideUp(100);
                    }
            );

        });
    </script>
</head>
<body>

<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div id="page-body" role="main">

    <div id="controller-list" role="navigation">
        <h2>Módulos:</h2>
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                <li class="controller"><g:link controller="${c.logicalPropertyName}">Cadastro de ${c.name}</g:link></li>
            </g:each>
        </ul>
    </div>


</div>

</body>
</html>

<!doctype html>
<html>
<head>

    <title>SGD - Sistema de Gestão de Doações</title>
    <link rel="stylesheet" href="${resource(dir: 'css/extjs/style/css', file: 'ext-all.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery.treeview.css')}" type="text/css">
    <script type="text/javascript" src="${resource(dir: 'js/extjs', file: 'ext-all.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js/extjs', file: 'bootstrap.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.treeview.js')}"></script>

    <style type="text/css">
    p {
        margin:5px;
    }
    .settings {
        background-image:url("${resource(dir: 'css/shared/icons/fam', file: 'folder_wrench.png')}");
    }
    .nav {
        background-image:url("${resource(dir: 'css/shared/icons/fam', file: 'folder_go.gif')}");
    }
    .info {
        background-image:url("${resource(dir: 'css/shared/icons/fam', file: 'information.png')}");
    }
    </style>

    <script>
        /*
         $(document).ready(function(){
         $("#browser").treeview();
         });
         */

        Ext.require(['*']);

        Ext.onReady(function() {

            Ext.QuickTips.init();

            // NOTE: This is an example showing simple state management. During development,
            // it is generally best to disable state management as dynamically-generated ids
            // can change across page loads, leading to unpredictable results.  The developer
            // should ensure that stable state ids are set for stateful components in real apps.
            Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));

            var viewport = Ext.create('Ext.Viewport', {
                id: 'border-example',
                layout: 'border',
                items: [
                    // create instance immediately
                    Ext.create('Ext.Component', {
                        region: 'north',
                        height: 60, // give north and south regions a height
                        autoEl: {
                            tag: 'div',
                            html:'<p>SGD - Sistema de Gestão de Doações</p>'
                        }
                    })
                    , {
                        // lazily created panel (xtype:'panel' is default)
                        region: 'south',
                        contentEl: 'south',
                        split: true,
                        height: 50,
                        minSize: 100,
                        maxSize: 200,
                        collapsible: true,
                        collapsed: false,
                        title: 'South',
                        margins: '0 0 0 0'
                    }
                    ,
                    {
                        //xtype: 'tabpanel',
                        region: 'east',
                        id: 'east-panel',
                        title: 'East Side',
                        split: true,
                        width: 200,
                        minWidth: 175,
                        maxWidth: 400,
                        collapsible: true,
                        animCollapse: true,
                        margins: '0 0 0 5',
                        layout: 'accordion',
                        items: [{
                            contentEl: 'east',
                            title: 'Navigation',
                            iconCls: 'nav' // see the HEAD section for style used
                        }, {
                            title: 'Settings',
                            html: '<p>Some settings in here.</p>',
                            iconCls: 'settings'
                        }, {
                            title: 'Information',
                            html: '<p>Some info in here.</p>',
                            iconCls: 'info'
                        }]
                    }, {
                        region: 'west',
                        id: 'west-panel', // see Ext.getCmp() below
                        title: 'West',
                        split: true,
                        width: 200,
                        minWidth: 175,
                        maxWidth: 400,
                        collapsible: true,
                        animCollapse: true,
                        margins: '0 0 0 5',
                        layout: 'accordion',
                        items: [{
                            contentEl: 'west',
                            title: 'Navigation',
                            iconCls: 'nav' // see the HEAD section for style used
                        }, {
                            title: 'Settings',
                            html: '<p>Some settings in here.</p>',
                            iconCls: 'settings'
                        }, {
                            title: 'Information',
                            html: '<p>Some info in here.</p>',
                            iconCls: 'info'
                        }]
                    },
                    // in this instance the TabPanel is not wrapped by another panel
                    // since no title is needed, this Panel is added directly
                    // as a Container
                    Ext.create('Ext.tab.Panel', {
                        region: 'center', // a center region is ALWAYS required for border layout
                        deferredRender: false,
                        activeTab: 0,     // first tab initially active
                        items: [{
                            contentEl: 'center1',
                            title: 'Fechar',
                            closable: true,
                            autoScroll: true
                        }, {
                            contentEl: 'center2',
                            title: 'Ações',
                            autoScroll: true
                        }]
                    })]
            });
            // get a reference to the HTML element with id "hideit" and add a click listener to it
            Ext.get("hideit").on('click', function(){
                // get a reference to the Panel that was created with id = 'west-panel'
                var w = Ext.getCmp('west-panel');
                // expand or collapse that Panel based on its collapsed property state
                w.collapsed ? w.expand() : w.collapse();
            });

            $("#browser").treeview();
        });
    </script>

</head>


<body>
<!-- use class="x-hide-display" to prevent a brief flicker of the content -->
<div id="west" class="x-hide-display">
    <ul id="browser" class="filetree">
        <li><span class="folder">Cadastros</span>
            <ul>
                <li><span class="file">Semeador</span></li>
                <li><span class="file">Igreja</span></li>
                <li><span class="file">Congregação</span></li>
                <li><span class="file">Campanha</span></li>
                <li><span class="file">Projeto</span></li>
                <li><span class="file">Perfil</span></li>
                <li><span class="file">Usuário</span></li>
            </ul>
        </li>
        <li class="closed"><span class="folder">Consultas</span>
            <ul>
                <li><span class="folder">Doações</span>
                    <ul id="folder21">
                        <li><a href="#"><span class="file">Por Semeador</span></a></li>
                        <li><span class="file">Por Congregação</span></li>
                        <li><span class="file">Por Campanha</span></li>
                    </ul>
                </li>
                <li><span class="file">File 2.2</span></li>
            </ul>
        </li>
        <li class="closed"><span class="folder">Folder 3 (closed at start)</span>
            <ul>
                <li><span class="file">File 3.1</span></li>
            </ul>
        </li>
        <li><span class="file">File 4</span></li>
    </ul>
</div>

<div id="east" class="x-hide-display">
    <p>Hi. I'm the east panel.</p>
</div>

<div id="center2" class="x-hide-display">
    <a id="hideit" href="#">Toggle the west region</a>
    <g:include controller="congregacao" action="list" > </g:include>
</div>
<div id="center1" class="x-hide-display">
    <p><b>Done reading me? Close me by clicking the X in the top right corner.</b></p>
    <p>Vestibulum semper. Nullam non odio. Aliquam quam. Mauris eu lectus non nunc auctor ullamcorper. Sed tincidunt molestie enim. Phasellus lobortis justo sit amet quam. Duis nulla erat, varius a, cursus in, tempor sollicitudin, mauris. Aliquam mi velit, consectetuer mattis, consequat tristique, pulvinar ac, nisl. Aliquam mattis vehicula elit. Proin quis leo sed tellus scelerisque molestie. Quisque luctus. Integer mattis. Donec id augue sed leo aliquam egestas. Quisque in sem. Donec dictum enim in dolor. Praesent non erat. Nulla ultrices vestibulum quam.</p>
    <p>Duis hendrerit, est vel lobortis sagittis, tortor erat scelerisque tortor, sed pellentesque sem enim id metus. Maecenas at pede. Nulla velit libero, dictum at, mattis quis, sagittis vel, ante. Phasellus faucibus rutrum dui. Cras mauris elit, bibendum at, feugiat non, porta id, neque. Nulla et felis nec odio mollis vehicula. Donec elementum tincidunt mauris. Duis vel dui. Fusce iaculis enim ac nulla. In risus.</p>
    <p>Donec gravida. Donec et enim. Morbi sollicitudin, lacus a facilisis pulvinar, odio turpis dapibus elit, in tincidunt turpis felis nec libero. Nam vestibulum tempus ipsum. In hac habitasse platea dictumst. Nulla facilisi. Donec semper ligula. Donec commodo tortor in quam. Etiam massa. Ut tempus ligula eget tellus. Curabitur id velit ut velit varius commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Fusce ornare pellentesque libero. Nunc rhoncus. Suspendisse potenti. Ut consequat, leo eu accumsan vehicula, justo sem lobortis elit, ac sollicitudin ipsum neque nec ante.</p>
    <p>Aliquam elementum mauris id sem. Vivamus varius, est ut nonummy consectetuer, nulla quam bibendum velit, ac gravida nisi felis sit amet urna. Aliquam nec risus. Maecenas lacinia purus ut velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse sit amet dui vitae lacus fermentum sodales. Donec varius dapibus nisl. Praesent at velit id risus convallis bibendum. Aliquam felis nibh, rutrum nec, blandit non, mattis sit amet, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam varius dignissim nibh. Quisque id orci ac ante hendrerit molestie. Aliquam malesuada enim non neque.</p>
</div>

<div id="props-panel" class="x-hide-display" style="width:200px;height:200px;overflow:hidden;">
</div>

<div id="south" class="x-hide-display">
    <div align="center">Copyright &copy; 2012 - IGREJA EVANGÉLICA ASSEMBLÉIA DE DEUS - BELA VISTA</div>
</div>
</body>
</html>

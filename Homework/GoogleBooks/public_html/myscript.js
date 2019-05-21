/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*$() Selector de contenido*/

/*Hace que una función esté disponible después de cargar el documento*/
$(document).ready(function () {
    /*Escucha el evento submit del boton ubicado en myform*/
    $("#myform").submit(function () {

        var search = $("#books").val();

        if (search == '') {

            alert("Please enter something in the field first");

        } else {

            var url = '';
            var img = '';
            var title = '';
            var author = '';
            var ISBN = '';
            
            /*Ejecuta la consulta y activa la funcion que tiene como parametro la respuesta de dicha consulta*/
            $.get("https://www.googleapis.com/books/v1/volumes?q=" + search +"&key=MyApiKey", function (response) {
                
                for (i = 0; i < response.items.length; i++) {
                                        
                    title = $('<h5 class="center-align black-text"> Title: ' + response.items[i].volumeInfo.title + '</h5>');
                    author = $('<h5 class="center-align black-text"> Author: ' + response.items[i].volumeInfo.authors + '</h5>');
                    img = $('<img class="aligning card z-depth-5" id=dynamic><br><a href=' + response.items[i].volumeInfo.infoLink + '><button id="imagebutton" class="btn red aligning">Read More</button></a>');
                    ISBN = $('<h5 class="center-align black-text"> ISBN: ' + response.items[i].volumeInfo.industryIdentifiers[1].identifier + '</h5>');
                    url = response.items[i].volumeInfo.imageLinks.thumbnail;
                    img.attr('src', url);//attach the image url
                    
                    /*Inserta contenido en el contenedor de destino*/
                    title.appendTo('#result');                    
                    author.appendTo('#result');
                    ISBN.appendTo('#result')
                    img.appendTo('#result');
                    

                }
            });
        }

        return false;

    });
});
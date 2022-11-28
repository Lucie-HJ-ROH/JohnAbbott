// JavaScript source code fo
//
// StarTrackr web page


// $(document).ready(function() {
//     //jquery statements
//
// })
//
// $(function() {
//     //jquery statements
// })
//
// $(()=>{
//     //jquery statements
// });

// $(()=>{
//     //find the number of even row in the body of the table
//     window.alert($('#celebs tbody tr:even').length + ' even elements');
// });


// $(()=>{
//     //get the font size of the first tr in tbody
//     var thefontSize = $('#celebs tbody tr:first').css('font-size');
//     alert(thefontSize);
// });
//
// $(()=>{
//     //get the font size of the first tr in tbody
//     $('#celebs tbody tr:first').css('background-color', 'lightgrey');
//     $('#celebs tbody tr:first').css('color', 'blue');
// });


// $(() => {
//     $('#celebs tbody tr:first').css({
//         'background-color': 'lightgrey',
//         'color': 'blue',
//         'font-size': '12px',
//         'line-height': '2.5rem'
//     });
// });

// $(()=>{
//     //jquery statements
//     $('#celebs tbody tr:even').addClass('zebra');
//     $('#celebs tbody tr:even').removeClass('zebra');
// });
//
//
// $(()=>{
//     $('#disclaimer').click(function(){
//         $('#disclaimer').hide();
//     })
// });

//
// $(()=>{
//     //show the paragraphs with id disclimer
//     $('#disclaimer').click(function(){
//         $('#disclaimer').show();
//     })
// });


// $(()=>{
//     //fade out the paragraphs with  id disclaimer
//     $('#disclaimer').click(function(){
//         $('#disclaimer').fadeOut();
//     })
// });

$(()=>{
    //jquery statements
    $('#celebs tbody tr:even').addClass('zebra');
    $('#celebs tbody tr').mouseover(function(){
        $(this).addClass('zebraHover');
    });
    $('#celebs tbody tr').mouseout(function(){
        $(this).removeClass('zebraHover');
    });

});
$(()=>{
    //jquery statements
});
$(()=>{
    //jquery statements
});
$(document).ready(function() {


    alert($("p").html());

    $("button").click(function() {
        $("div").hide();
    })

    $("p").addClass("redbox");

});
$(function(){
    $("#more").click(function() {
        console.log("clicked");
        var last_page = parseInt($(this).attr("last-page")) + 2;

        $.ajax({
            method:"GET",
            url: "/restaurants",
            data : {"page":last_page}
        })
            .done(function(response){
                console.log("done");
                console.log(response);
                if(response.length > 0) {
                    for(var restaurant of response) {
                        $("#more-blogs").append(
                            "<div>" +
                            "<a href=\"#\">" +
                            "<h2>" + restaurant.name + "</h2>"
                        );
                    }
                }
                else {
                    alert('last data');
                }
            })
            .always(function(response){
                console.log("always");
                console.log(response);
            });
        $(this).attr("last-page", last_page);
    });
});
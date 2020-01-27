function print() {
}
const api = "http://localhost:8080/api/printers";

function getData(){
          var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                  if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("demo").innerHTML = this.responseText;
                   parseJson(this.responseText);
                  }
                };
                xhttp.open("GET", api);
                xhttp.setRequestHeader("Content-type", "application/json");
                xhttp.send();
}

 function sendPrinter(){
                var type = document.getElementById("type").value;
                var price = document.getElementById("price").value;

                var printer = {type:type, price:price};
                postData(JSON.stringify(printer));
 }

 function postData(data){
     var xhttp = new XMLHttpRequest();
                 xhttp.onreadystatechange = function() {
                         if (this.readyState == 4 && this.status == 201) {
                           document.getElementById("demo").innerHTML = this.responseText;
                         }
                 };
                 xhttp.open("POST", api, true);
                 xhttp.setRequestHeader("Content-type", "application/json");
                 xhttp.send(data);
         }

function parseJson(data) {
    // hopefully data contains a String containing a list of printers
    let printers = JSON.parse(data);

    for(let printer of printers) {
        console.log(`found a printer with id: ${printer.id} and price:${printer.price} and type:${printer.type}`);
    }
    // and you can do a lot more of it
  }

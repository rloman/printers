const api = "http://localhost:8080/api/printers";

function getData(){
          let xhttp = new XMLHttpRequest();
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
                let type = document.getElementById("type").value;
                let price = document.getElementById("price").value;

                let printer = {
                    type:type,
                    price:price};
                postData(JSON.stringify(printer));
 }

 function postData(data){
     var xhttp = new XMLHttpRequest();
                 xhttp.onreadystatechange = function() {
                         if (this.readyState == 4 && this.status == 200) {
                           document.getElementById("demo").innerHTML = this.responseText;
                         }
                 };
                 xhttp.open("POST", api, true);
                 xhttp.setRequestHeader("Content-type", "application/json");
                 xhttp.send(data);// data is STring hiere!
         }

function parseJson(dataString) {
    // hopefully data contains a String containing a list of printers
    let printers = JSON.parse(dataString);

    for(let printer of printers) {
        console.log(`found a printer with id: ${printer.id} and price:${printer.price} and type:${printer.type}`);
    }
    // and you can do a lot more of it
  }

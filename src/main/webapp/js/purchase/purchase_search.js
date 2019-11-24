let xhr = new XMLHttpRequest();
let url = "api/purchase";

xhr.open("GET", url, true);

xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let response = JSON.parse(xhr.responseText);
            let products = response.data;

            // cabeseras de tabla
            let cabeceras = ["ID", "NOMBRE", "DESCRIPCION", "PRODUCTO", "DATO", "CANTIDAD", "TIEMPO"];
            let nombresCampos = ["id", "name", "description", "product", "date", "quantity","time"];

            let table = document.createElement("table");

            let tr = table.insertRow(-1);

        for (let i = 0; i < cabeceras.length; i++) {
            let th = document.createElement("th")
            th.innerHTML = cabeceras[i];
            tr.appendChild(th);
        }

             for(let i = 0; i < products.length; i++) {
            tr = table.insertRow(-1);
            
            for(let j = 0; j < nombresCampos.length; j++) {
                let tabCell = tr.insertCell(-1);
                tabCell.innerHTML = products[i][nombresCampos[j]];
                }
            }
            var divContainer = document.getElementById("showData");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
        }
};

xhr.send();
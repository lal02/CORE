const tempGraph = document.getElementById("temperatureGraph").getContext('2d');
const soilGraph = document.getElementById("soilGraph").getContext('2d');
const lightGraph = document.getElementById("lightGraph").getContext('2d');

const todayButton = document.getElementById("todayButton");
const monthButton = document.getElementById("monthButton");
const yearButton = document.getElementById("yearButton");
const alltimeButton = document.getElementById("alltimeButton");

const todaySoilButton = document.getElementById("todaySoilButton");
const monthSoilButton = document.getElementById("monthSoilButton");
const yearSoilButton = document.getElementById("yearSoilButton");
const alltimeSoilButton = document.getElementById("alltimeSoilButton");

const todayLightButton = document.getElementById("todayLightButton");
const monthLightButton = document.getElementById("monthLightButton");
const yearLightButton = document.getElementById("yearLightButton");
const alltimeLightButton = document.getElementById("alltimeLightButton");

let humTempGraph;

let soilHumGraph;

let lightSensorGraph;


todayButton.onclick = function () {
    renderTempGraph("today").then(r => null);
}
monthButton.onclick = function () {
    renderTempGraph("month").then(r => null);
}
yearButton.onclick = function () {
    renderTempGraph("year").then(r => null);
}
alltimeButton.onclick = function () {
    renderTempGraph("all").then(r => null);
}


todaySoilButton.onclick = function () {
    renderSoilGraph("today").then(r => null);
}


monthSoilButton.onclick = function () {
    renderSoilGraph("month").then(r => null);
}

yearSoilButton.onclick = function () {
    renderSoilGraph("year").then(r => null);
}

alltimeSoilButton.onclick = function () {
    renderSoilGraph("all").then(r => null);
}



todayLightButton.onclick = function () {
    renderLightGraph("today").then(r => null);
}


monthLightButton.onclick = function () {
    renderLightGraph("month").then(r => null);
}

yearLightButton.onclick = function () {
    renderLightGraph("year").then(r => null);
}

alltimeLightButton.onclick = function () {
    renderLightGraph("all").then(r => null);
}

async function fetchData(api){
        const response = await fetch(api);
        return await response.json();
}


async function renderTempGraph(time){
    const temperatureData = await fetchData("/api/temperatur/" + time);
    temperatureData.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const temperatureLabels = temperatureData.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const temperatureYValues = temperatureData.map(data => data.value);

    const humidityData = await fetchData("/api/humidity/" + time);
    humidityData.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));
    const humidityLabels = humidityData.map(data => new Date(data.timestamp).toLocaleString());
    const humidityYValues = humidityData.map(data => data.value);

    if (humTempGraph) {
        // Update existing chart
        humTempGraph.data.labels = temperatureLabels;

        humTempGraph.data.datasets[0].data = temperatureYValues; // Update temperature data
        humTempGraph.data.datasets[1].data = humidityYValues;    // Update humidity data
        humTempGraph.update(); // Update the chart
    }
    else{
        humTempGraph = new Chart(tempGraph, {
            type: 'line',
            data: {
                labels: temperatureLabels, // X-Achsen-Beschriftungen
                datasets: [{
                    label: 'Temperatur',
                    data: temperatureYValues, // Y-Achsen-Werte
                    backgroundColor: 'rgba(255, 0, 0, 0.2)',
                    borderColor: 'rgba(255, 0, 0, 1)',
                    borderWidth: 1
                }
                    ,
                    {
                        label: 'Humidity',
                        data: humidityYValues, // Y-Achsen-Werte
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }
                ]
            }
        });
    }

}

async function renderSoilGraph(time){
    const soilhumiditydata = await fetchData("/api/soilhumidity/" + time);
    console.log(soilhumiditydata);
    soilhumiditydata.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const soilHumidityLabels = soilhumiditydata.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const soilHumidityYValues = soilhumiditydata.map(data => data.value);

    if (soilHumGraph) {
        // Update existing chart
        soilHumGraph.data.labels = soilHumidityLabels;
        soilHumGraph.data.datasets[0].data = soilHumidityYValues;    // Update humidity data
        soilHumGraph.update(); // Update the chart
    }
    else{
        soilHumGraph = new Chart(soilGraph, {
            type: 'line',
            data: {
                labels: soilHumidityLabels, // X-Achsen-Beschriftungen
                datasets: [{
                    label: 'Soil Humidity',
                    data: soilHumidityYValues, // Y-Achsen-Werte
                    backgroundColor: 'rgba(255, 0, 0, 0.2)',
                    borderColor: 'rgba(255, 0, 0, 1)',
                    borderWidth: 1
                }]
            }
        });
    }

}

async function renderLightGraph(time){
    const lightdata = await fetchData("/api/light/" + time);
    console.log(lightdata);
    lightdata.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const lightLabels = lightdata.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const lightYValues = lightdata.map(data => data.value);

    if (lightSensorGraph) {
        // Update existing chart
        lightSensorGraph.data.labels = lightLabels;
        lightSensorGraph.data.datasets[0].data = lightYValues;    // Update humidity data
        lightSensorGraph.update(); // Update the chart
    }
    else{
        lightSensorGraph = new Chart(lightGraph, {
            type: 'line',
            data: {
                labels: lightLabels, // X-Achsen-Beschriftungen
                datasets: [{
                    label: 'Lux',
                    data: lightYValues, // Y-Achsen-Werte
                    backgroundColor: 'rgba(255, 0, 0, 0.2)',
                    borderColor: 'rgba(255, 0, 0, 1)',
                    borderWidth: 1
                }]
            }
        });
    }

}

renderTempGraph("today").then(r => null);
renderSoilGraph("today").then(r => null);
renderLightGraph("today").then(r => null);


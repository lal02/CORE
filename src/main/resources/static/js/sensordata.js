const tempGraph = document.getElementById("temperatureGraph").getContext('2d');

const todayButton = document.getElementById("todayButton");
const monthButton = document.getElementById("monthButton");
const yearButton = document.getElementById("yearButton");
const alltimeButton = document.getElementById("alltimeButton");

let meinGraph;

todayButton.onclick = function () {
    renderGraph("today").then(r => null);
}
monthButton.onclick = function () {
    renderGraph("month").then(r => null);
}
yearButton.onclick = function () {
    renderGraph("year").then(r => null);
}
alltimeButton.onclick = function () {
    renderGraph("all").then(r => null);
}

async function fetchData(api){
        const response = await fetch(api);
        return await response.json();
}


async function renderGraph(time){
    const temperatureData = await fetchData("/api/temperatur/" + time);
    temperatureData.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const temperatureLabels = temperatureData.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const temperatureYValues = temperatureData.map(data => data.value);

    const humidityData = await fetchData("/api/humidity/" + time);
    humidityData.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));
    const humidityLabels = humidityData.map(data => new Date(data.timestamp).toLocaleString());
    const humidityYValues = humidityData.map(data => data.value);

    if (meinGraph) {
        // Update existing chart
        meinGraph.data.labels = temperatureLabels;

        meinGraph.data.datasets[0].data = temperatureYValues; // Update temperature data
        meinGraph.data.datasets[1].data = humidityYValues;    // Update humidity data
        meinGraph.update(); // Update the chart
    }
    else{
        meinGraph = new Chart(tempGraph, {
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

renderGraph("today").then(r => null);



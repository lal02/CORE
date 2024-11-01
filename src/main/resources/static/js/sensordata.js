const tempGraph = document.getElementById("temperatureGraph").getContext('2d');

async function fetchData(api){
        const response = await fetch(api);
        return await response.json();
}


async function renderGraph(){
    const temperatureData = await fetchData("/api/temperatur");
    console.log(temperatureData);
    const temperatureLabels = temperatureData.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const temperatureYValues = temperatureData.map(data => data.value);

    const humidityData = await fetchData("/api/humidity");
    console.log(humidityData);
    const humidityLabels = humidityData.map(data => new Date(data.timestamp).toLocaleString());
    const humidityYValues = humidityData.map(data => data.value);

    const meinGraph = new Chart(tempGraph, {
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

renderGraph().then(r => null);

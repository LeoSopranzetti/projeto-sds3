import axios from 'axios'
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale'


type ChartData = {
    labels: string[];
    series: number[]
}

function DonutChart() {

    let chartData : ChartData = {labels :[], series : []}

    axios.get(`http://localhost:8080/sales/sum-by-seller`)
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            chartData = {labels :myLabels, series : mySeries}

            console.log(chartData);
        })

    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
       <Chart 
            options={{ ...options, labels: chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
       />
    );
  }
  
  export default DonutChart;
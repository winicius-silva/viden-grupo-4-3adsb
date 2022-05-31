import axios from 'axios'

const api = axios.create({
    baseURL : "http://174.129.43.180:8080/",
    headers: { "Access-Control-Allow-Origin": "*", "crossorigin": true }
});

// class ApiViden {
//     getCursoPorCategoria(categoria) {
//         return axios.get(`/cursos/filter/${categoria}`)
//     }
// }

// export default new ApiViden();

export default api
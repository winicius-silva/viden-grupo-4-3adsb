import axios from 'axios'

const api = axios.create({
    baseURL : "http://localhost:8080/"
});

// class ApiViden {
//     getCursoPorCategoria(categoria) {
//         return axios.get(`/cursos/filter/${categoria}`)
//     }
// }

// export default new ApiViden();

export default api
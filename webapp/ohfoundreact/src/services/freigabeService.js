import axios from 'axios';

export default {
  getAllFreigaben: async () => {
    let res = await axios.get(`http://localhost:5000/api/freigabe`);
    console.log("IN AXIOS: " + res)
    return res.data || [];
  }
}
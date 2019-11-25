import axios from 'axios';

export default {
  getAllArtikel: async () => {
    let res = await axios.get(`http://localhost:5000/api/artikel`);
    console.log("IN AXIOS: " + res)
    return res.data || [];
  }
}
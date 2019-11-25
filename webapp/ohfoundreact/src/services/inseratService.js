import axios from 'axios';

export default {
  getAllInserate: async () => {
    let res = await axios.get(`http://localhost:5000/api/inserat`);
    console.log("IN AXIOS: " + res.data)
    return res.data || [];
  }
}
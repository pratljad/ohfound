import axios from 'axios';

export default {
  getAllLocations: async () => {
    let res = await axios.get(`http://localhost:5000/api/location`);
    console.log("IN AXIOS: " + res)
    return res.data || [];
  }
}
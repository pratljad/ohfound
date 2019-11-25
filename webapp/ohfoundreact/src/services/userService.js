import axios from 'axios';

export default {
  getAllUsers: async () => {
    let res = await axios.get(`http://localhost:5000/api/user`);
    console.log("IN AXIOS: " + res)
    return res.data || [];
  }
}
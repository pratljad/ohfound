import axios from 'axios';

export default {
  getAllLocations: async () => {
    let res = await axios.get(`http://localhost:5000/api/location`);
    console.log("IN AXIOS ALL LOCATIONS: " + res)
    return res.data || [];
  },

  getLocation: async (locationName) => {
    let res = await axios.get(`http://localhost:5000/api/location/` + locationName);
    console.log("IN AXIOS SINGLE LOCATION: " + res)
    return res.data || [];
  }
}
// /routes/productRoute.js
const mongoose = require('mongoose');
const Location = mongoose.model('locations');

module.exports = (app) => {

  app.get(`/api/location`, async (req, res) => {
    let locations = await Location.find();
    return res.status(200).send(locations);
  });

  app.post(`/api/location`, async (req, res) => {
    let location = await Location.create(req.body);
    return res.status(201).send({
      error: false,
      location
    })
  })

  app.put(`/api/location/:id`, async (req, res) => {
    const {id} = req.params;

    let location = await Location.findByIdAndUpdate(id, req.body);

    return res.status(202).send({
      error: false,
      location
    })

  });

  app.delete(`/api/location/:id`, async (req, res) => {
    const {id} = req.params;

    let location = await Location.findByIdAndDelete(id);

    return res.status(202).send({
      error: false,
      location
    })

  })

}
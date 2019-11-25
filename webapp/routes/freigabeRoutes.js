// /routes/productRoute.js
const mongoose = require('mongoose');
const Freigabe = mongoose.model('freigaben');

module.exports = (app) => {

  app.get(`/api/freigabe`, async (req, res) => {
    let freigaben = await Freigabe.find();
    return res.status(200).send(freigaben);
  });

  app.post(`/api/freigabe`, async (req, res) => {
    let freigabe = await Freigabe.create(req.body);
    return res.status(201).send({
      error: false,
      freigabe
    })
  })

  app.put(`/api/freigabe/:id`, async (req, res) => {
    const {id} = req.params;

    let freigabe = await Freigabe.findByIdAndUpdate(id, req.body);

    return res.status(202).send({
      error: false,
      freigabe
    })

  });

  app.delete(`/api/freigabe/:id`, async (req, res) => {
    const {id} = req.params;

    let freigabe = await Freigabe.findByIdAndDelete(id);

    return res.status(202).send({
      error: false,
      freigabe
    })

  })

}
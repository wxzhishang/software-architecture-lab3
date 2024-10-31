var express = require('express');
var router = express.Router();
var { searchController } = require('./controller/index')

/* GET users listing. */
router.get('/', async function(req, res, next) {
  const result = await searchController()
  res.status(result.code).send(result);
});

router.post('/', function(req, res, next) {
  const { name, tel } = req.body
  res.send('respond with a resource');
});

router.put('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.delete('/:id', function(req, res, next) {
  res.send('respond with a resource');
});


module.exports = router;

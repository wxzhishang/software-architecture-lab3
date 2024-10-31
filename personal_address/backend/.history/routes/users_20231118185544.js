var express = require('express');
var router = express.Router();
var { searchController } = require('./controller/index')

/* GET users listing. */
router.get('/', async function(req, res, next) {
  const res = await searchController()
  res.status(res.code).send(res);
});

router.post('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.put('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.delete('/:id', function(req, res, next) {
  res.send('respond with a resource');
});


module.exports = router;

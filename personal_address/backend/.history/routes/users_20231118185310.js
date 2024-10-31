var express = require('express');
var router = express.Router();
var { searchController } = require('./controller/index')

/* GET users listing. */
router.get('/', function(req, res, next) {
  console.log('666')
  res.send('respond with a resource');
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


// Requiring module
const express = require('express');
 
// Creating express object
const front = express();
 
// Handling GET request
front.get('/', (req, res) => {
    res.send('PluggableAuthFrontEnd says hello world!')
    res.end()
})
 
// Port Number
const PORT = process.env.PORT ||5000;
 
// Server Setup
front.listen(PORT,console.log(
  `Server started on port ${PORT}`));
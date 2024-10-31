const { userModel } = require("../../model/user")
const mongoose = require("mongoose")
const http_code = {
    success: 200,
    error: 404
}

const searchUser = async () => {
    let list = []
    let code = http_code.success
    try {

     }catch (err) {
        code = http_code.error
      }
}
const { userModel } = require("../../model/user")
const mongoose = require("mongoose")
const http_code = {
    success: 200,
    error: 404
}

const searchController = async () => {
    let list = []
    let code = http_code.success
    try {
        list = await userModel.find()
    }catch (err) {
        code = http_code.error
    }

    return {
        code: code,
        data: list
    }
}


module.exports = { searchController }
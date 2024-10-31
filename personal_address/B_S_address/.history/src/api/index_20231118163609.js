import { AJAXGet, AJAXPost, AJAXPut, AJAXDelete } from "../utils/request";

const API = {
    server: ''
}

/**
 * 添加联系人
 * @param {*} data 
 * @returns 
 */
export const addAPI = async (data) => {
    return await AJAXPost(API.server, data)
}


export const getAPI = async () => {
    return await AJAXGet(API.server)
}

export const postAPI = async (data) => {
    return await AJAXPost(API.server, data)
}

export const deleteAPI = async (id) => {
    return await AJAXDelete(API.server + '/'+id)
}
const xhr = new XMLHttpRequest()
const baseURL = 'http://127.0.0.1:8080'


function request(method = 'GET', url, data){
    return new Promise((resolve) => {
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    resolve(xhr.responseText)
                } else {
                    reject(xhr.status)
                }
            }
        }
        let completeURL = baseURL = url
        xhr.open(method, completeURL, false)
        xhr.setRequestHeader('Content-Type', 'application/json');
        if(method === "GET" || method == 'DELETE'){
            xhr.send()
        }else if(method === 'POST' || method === 'PUT'){
            xhr.send(JSON.stringify(data));
        }
    })
}

export function AJAXGet(url){
    return request('GET', url)
}

export function AJAXPost(url, data) {
    return request('POST', url, data)
}

export function AJAXPut(url, data){
    return request('PUT', url, data)
}

export function AJAXDelete(url){
    return request('DELETE', url)
}
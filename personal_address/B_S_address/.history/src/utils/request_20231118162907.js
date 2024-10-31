const xhr = new XMLHttpRequest()
const baseURL = 'http://127.0.0.1:8080'


export function request(method = 'GET', url){
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
        xhr.open(method, url, false)
        xhr.setRequestHeader('Content-Type', 'application/json');
        if(method === "GET" || method == 'DELETE'){
            xhr.send()
        }else if(method === 'POST' || method === 'PUT'){
            xhr.send(JSON.stringify(data));
        }
    })
}

export function AJAXGet(url, )
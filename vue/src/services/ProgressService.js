import axios from 'axios';

export default {
    retrieveProgressByEventForAllUsers(){
        return axios.get(`/progress/1`)
    }
}
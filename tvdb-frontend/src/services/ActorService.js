import axios from 'axios';

const BASE_API_URL = 'http://localhost:8888'

class ActorService {
    
    getTopActorsByUser(username) {
        return axios.get(`${BASE_API_URL}/topActors/${username}`);
    }

    getActors() {
        return axios.get(`${BASE_API_URL}/actors`);
    }

}
export default new ActorService();
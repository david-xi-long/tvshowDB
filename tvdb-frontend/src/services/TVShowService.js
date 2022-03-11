import axios from 'axios';
const TVSHOW_REST_API_URL = 'http://localhost:8888/tvshows'
class TVShowService {
    getTVShows() {
        return axios.get(TVSHOW_REST_API_URL);
    }
}
export default new TVShowService();
import './App.css';
import { useState, useEffect } from 'react';

function Album({ id, albumTitle, releaseDate }) {
  return (
    <div>
      <h1>{id}</h1>
      <p>{albumTitle}</p>
      <p>{releaseDate}</p>
    </div>
  );
}

function App() {
  const [data, setData] = useState(null);
  // Different states
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  useEffect(() => {
    setLoading(true);
    // fetch is used to make an HTTP request
    fetch(`/albums`, {
      method: 'GET',
    })
      // convert the response to json
      .then((response) => response.json())
      // take the data and call setData on it
      .then(setData)
      // data is finished loading so reset loading state
      .then(() => setLoading(false))
      .catch(setError); // catch error, run setError
  }, []); // This empty array is the dependency array - only run this on open
  // Preformatted tag to format some JSON

  if (loading) return <h1>Loading...</h1>;
  if (error) return <pre>{JSON.stringify(error)}</pre>;
  if (!data) return null;
  console.log(data, 'DATA!!!');
  return (
    <div>
      {data.map((album) => (
        <Album
          id={album.id}
          albumTitle={album.albumTitle}
          releaseDate={album.releaseDate}
        />
      ))}
    </div>
  );
}

export default App;

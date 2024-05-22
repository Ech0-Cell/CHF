const express = require('express');
const app = express();


app.use(express.json());

app.post('/api/usage', (req, res) => {
    const { msisdn, callDate, volume, serviceType, destination } = req.body;

    
    if (!msisdn || !callDate || !volume || !serviceType || !destination) {
        return res.status(400).send('Missing parameters');
    }

    // check if the usage is granted here
   
    if (serviceType === 'Data' || serviceType === 'Voice' || serviceType === 'SMS') {
        return res.json({ status: 'SUCCESS' });
    } else {
        return res.status(403).send('Usage not granted');
    }
});

const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Server running on port ${port}`));

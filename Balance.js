const voltClient = require('volt-client'); // idk the voltDB part tbh to this is hypothatically :P

app.post('/api/charge', async (req, res) => {
    const { msisdn, volume } = req.body;

    
    if (!msisdn || !volume) {
        return res.status(400).send('Missing parameters');
    }

    try {
        // gettin the subscriber balance is here
        const balance = await voltClient.getSubscriberBalance(msisdn);

        
        if (balance < volume) {
            return res.status(403).send('Low balance');
        }

        // Deduct the usage from the subscriber's balance
        await voltClient.deductFromBalance(msisdn, volume);

        return res.json({ status: 'SUCCESS' });
    } catch (error) {
        console.error(error);
        return res.status(500).send('Server error');
    }
});

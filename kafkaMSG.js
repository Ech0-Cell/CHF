const kafka = require('kafka-node'); // also hypothetical Kafka client cause idk how to connect but will do (soon i hope)

const client = new kafka.KafkaClient({kafkaHost: 'localhost:9092'});
const producer = new kafka.Producer(client);

producer.on('ready', () => {
    const messages = [
        { topic: 'UsageDelta', messages: 'Your message for UsageDelta' },
        { topic: 'UsageRecord', messages: 'Your message for UsageRecord' },
        { topic: 'Notification', messages: 'Your message for Notification' }
    ];

    producer.send(messages, (err, result) => {
        console.log(err || result);
    });
});

producer.on('error', (err) => {
    console.log('error', err);
});

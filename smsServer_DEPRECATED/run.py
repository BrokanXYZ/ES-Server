from flask import Flask, request
from twilio.twiml.messaging_response import MessagingResponse

app = Flask(__name__)

@app.route("/sms", methods=['POST'])
def get_sms():
    message = request.values.get('Body', None)
    print("\nNew message: \"" + message + "\"")
    return ('', 204)

if __name__ == "__main__":
    app.run(debug=True)


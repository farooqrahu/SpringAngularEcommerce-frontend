export class JwtAuthResponsePayload {
  constructor(public token: string,
              public user: User) {
  }
}

class User {
  username: string;
}
